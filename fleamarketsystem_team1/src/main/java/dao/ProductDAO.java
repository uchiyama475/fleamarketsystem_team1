package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.Product;

public class ProductDAO {

	//JDBCドライバ内部のDriverクラスパス
	private static String RDB_DRIVE = "org.mariadb.jdbc.Driver";

	//接続するMySQLデータベース
	private static String URL = "jdbc:mariadb://localhost/mybookdb";

	//データベースのユーザー名
	private static String USER = "root";
	

	//データベースのパスワード
	private static String PASSWD = "root123";

	/**
	 * DB接続を行うメソッド定義
	 */
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(RDB_DRIVE);
			con = DriverManager.getConnection(URL, USER, PASSWD);
			return con;
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
	}

	/**
	 * 全商品情報を取得するメソッド
	 */
	public ArrayList<Product> selectAll() {

		Connection con = null;
		Statement smt = null;

		ArrayList<Product> list = new ArrayList<Product>();

		try {

			con = getConnection();
			smt = con.createStatement();

			String sql = "SELECT * FROM product_info";

			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				Product product = new Product();
				product.setProductid(rs.getInt("productid"));
				product.setUserid(rs.getInt("userid"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				product.setQuantity(rs.getInt("quantity"));
				product.setDescription(rs.getString("description"));
				product.setSelldate(rs.getString("selldate"));
				list.add(product);
			}

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
		return list;
	}

	/**
	 * 条件から合致する商品情報を取得するメソッド
	 */
	public Product selectByProduct(String productid) {

		Connection con = null;
		Statement smt = null;

		Product product = new Product();

		try {

			con = getConnection();
			smt = con.createStatement();

			String sql = "SELECT * FROM productinfo WHERE product_id =" + productid;

			ResultSet rs = smt.executeQuery(sql);

			while (rs.next()) {
				product.setProductid(rs.getInt("productid"));
				product.setUserid(rs.getInt("userid"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				product.setQuantity(rs.getInt("quantity"));
				product.setDescription(rs.getString("description"));
				product.setSelldate(rs.getString("selldate"));
			}

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
		return product;
	}

	/**
	 * 商品情報の新規登録を行うメソッド
	 */
	public int insert(Product productid) {

		Connection con = null;
		Statement smt = null;

		int count = 0;

		try {

			con = getConnection();
			smt = con.createStatement();

			String sql = "INSERT INTO productinfo VALUES(" 
					+ product.getProduct_id() + "," 
					+ product.getUser_id() + ",'"
					+ product.getName() + "',"
					+ product.price() + "," 
					+ product.getQuantity() + ",'" 
					+ product.getDescription() + "','"
					+ product.getSell_date() + "')";

			int rowsCount = smt.executeUpdate(sql);

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
		return count;
	}

	/**
	 * 商品情報を削除するメソッド
	 */
	public int delete(String product_id) {

		Connection con = null;
		Statement smt = null;

		int count = 0;

		try {

			con = getConnection();
			smt = con.createStatement();

			String sql = "DELETE FROM productinfo WHERE product_id =" + product_id;

			int rowsCount = smt.executeUpdate(sql);

		} catch (Exception e) {
			throw new IllegalStateException(e);
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}
		return count;
	}

}
