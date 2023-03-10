package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.Produit;

public class ProduitdaoImpl implements IProduitdao {

	@Override
	public Produit add(Produit p) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("insert into produit(designation,prix,quantite) values(?,?,?)");
			
			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.executeUpdate();
			
			PreparedStatement ps2 = connection.prepareStatement
					("select MAX(id) as MAX_ID from produit");
			ResultSet rs = ps2.executeQuery();
			if(rs.next()) {
				p.setId(rs.getInt("MAX_ID"));
			}
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Produit> produitparmc(String mc) {
		List<Produit> produit = new ArrayList<Produit>();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("select * from produit where designation like ?");
			ps.setString(1, mc);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Produit p = new Produit();
				p.setId(rs.getInt("id"));
				p.setDesignation(rs.getString("designation"));
				p.setPrix(rs.getDouble("prix"));
				p.setQuantite(rs.getInt("quantite"));
				produit.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return produit;
	}

	@Override
	public Produit getProduit(int id) {
		Produit p = null;
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("select * from produit where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				p = new Produit();
				p.setId(rs.getInt("id"));
				p.setDesignation(rs.getString("designation"));
				p.setPrix(rs.getDouble("prix"));
				p.setQuantite(rs.getInt("quantite"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	
	}

	@Override
	public Produit update(Produit p) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("update produit set designation=?,prix=?,quantite=? where id=?");
			
			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.setInt(4, p.getId());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public void delete(int id) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement
					("delete from produit where id=?");
			
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
