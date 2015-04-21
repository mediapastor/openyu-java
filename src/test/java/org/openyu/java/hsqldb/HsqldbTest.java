package org.openyu.java.hsqldb;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

/**
 * The Class HsqldbTest.
 */
public class HsqldbTest {

	/**
	 * Connection.
	 */
	@Test
	public void connection()
	{
		Connection conn = null;
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			conn = DriverManager.getConnection(
					"jdbc:hsqldb:hsql://localhost:9001/openyu_java"
					, "SA", "");
			//
			System.out.println(conn);
			assertTrue(conn != null);
		} catch (Exception ex)
		{
			ex.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception ex) {

				}
			}
		}
	}

	/**
	 * Creates the connection.
	 *
	 * @return the connection
	 */
	protected Connection createConnection() {
		Connection result = null;
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			result = DriverManager.getConnection(
					"jdbc:hsqldb:hsql://localhost:9001/openyu_java"
					, "SA", "");
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return result;
	}

	/**
	 * Close connection.
	 *
	 * @param conn
	 *            the conn
	 */
	protected void closeConnection(Connection conn) {

		try {
			if (conn != null) {
				conn.close();
			}

		} catch (Exception ex) {
		}

	}

	/**
	 * Close statement.
	 *
	 * @param stmt
	 *            the stmt
	 */
	protected void closeStatement(Statement stmt) {

		try {
			if (stmt != null) {
				stmt.close();
			}

		} catch (Exception ex) {
		}
	}

	/**
	 * Close result set.
	 *
	 * @param rs
	 *            the rs
	 */
	protected void closeResultSet(ResultSet rs) {

		try {
			if (rs != null) {
				rs.close();
			}

		} catch (Exception ex) {
		}
	}

	/**
	 * Creates the table.
	 */
	@Test
	public void createTable()
	{
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = createConnection();
			stmt = conn.createStatement();
			//
			System.out.println(stmt);
			assertTrue(stmt != null);

			String SQL =
					"CREATE TABLE magazine (" +
							"	id bigint not null," +
							"	name varchar(100)," +
							"   price int," +
							"	PRIMARY KEY (id)" +
							" );";
			stmt.executeUpdate(SQL);

		} catch (Exception ex)
		{
			ex.printStackTrace();
		} finally {
			// close
			closeStatement(stmt);
			closeConnection(conn);
		}
	}

	/**
	 * Adds the column.
	 */
	@Test
	public void addColumn()
	{
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = createConnection();
			stmt = conn.createStatement();
			//
			System.out.println(stmt);
			assertTrue(stmt != null);

			String SQL = "ALTER TABLE magazine ADD COLUMN buff varchar(100);";
			stmt.executeUpdate(SQL);

		} catch (Exception ex)
		{
			ex.printStackTrace();
		} finally {
			// close
			closeStatement(stmt);
			closeConnection(conn);
		}
	}

	/**
	 * Drop column.
	 */
	@Test
	public void dropColumn()
	{
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = createConnection();
			stmt = conn.createStatement();
			//
			System.out.println(stmt);
			assertTrue(stmt != null);

			String SQL = "ALTER TABLE magazine DROP COLUMN buff;";
			stmt.executeUpdate(SQL);

		} catch (Exception ex)
		{
			ex.printStackTrace();
		} finally {
			// close
			closeStatement(stmt);
			closeConnection(conn);
		}
	}

	/**
	 * Prepared statement.
	 */
	@Test
	public void preparedStatement()
	{

	}
}
