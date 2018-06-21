package cc.fbsky.base.webservice.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest
{

	public static void main(String[] args)
	{

		for (int index = 1; index < 10; index++)
		{
			new Thread()
			{
				@Override
				public void run()
				{
					// TODO Auto-generated method stub
					forUpdateSelect(null, false);
				}
			}.start();
		}

	}

	public static void forUpdateSelect(Connection conn, boolean isTrue)
	{
		conn = conn == null ? getConn() : conn;
		try
		{
			conn.setAutoCommit(isTrue);
		} catch (SQLException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql = "select REAL_BILL_WEIGHT from t_logi_bill b  where b.bill_id = 285 for update";
		PreparedStatement pstmt;
		try
		{
			pstmt = (PreparedStatement) conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			rs.next();
			double real = rs.getDouble("REAL_BILL_WEIGHT");

			Statement stat = conn.createStatement();
			String sql2 = "update t_logi_bill b set b.REAL_BILL_WEIGHT = " + (real + 1) + "where b.bill_id = 286";
			stat.executeUpdate(sql2);

			System.out.println(Thread.currentThread().getName() + ",get Select Result，" + isTrue + ",rs:" + real);

			try
			{
				Thread.sleep(5000L);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ",OVER，" + isTrue);

			// forUpdateSelect(conn,isTrue);
			conn.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public static void select1(String[] args)
	{
		Connection conn = getConn();
		String sql = "select * from t_logi_bill b  limit 10";
		PreparedStatement pstmt;
		try
		{
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			int col = rs.getMetaData().getColumnCount();
			System.out.println("============================");

			while (rs.next())
			{

				for (int i = 1; i <= col; i++)
				{
					System.out.print(rs.getString(i) + "\t");
					if ((i == 2) && (rs.getString(i).length() < 8))
					{
						System.out.print("\t");
					}
				}

				System.out.println("");
			}

			System.out.println("============================");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	private static Connection getConn()
	{
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://chemproduct.mysql.rds.aliyuncs.com:3306/uat_db_logistics";
		String username = "ccec";
		String password = "ccecpassword";
		Connection conn = null;
		try
		{
			Class.forName(driver); // classLoader,加载对应驱动
			conn = (Connection) DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return conn;
	}
}
