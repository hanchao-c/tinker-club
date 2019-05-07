package org.tinker.asset.persistent;

public interface PersistentNamedStatement {

	/**
	 * 数据源命名
	 */
	public static interface DataSources {
		
		/**
		 * DataSouce auth id
		 * 
		 * 同配置文件 spring-mybatis-auth.xml中bean HikariDataSource的id
		 */
		public static final String AUTH = "dataSource-auth";
		
		/**
		 * DataSouce cms id
		 * 
		 * 同配置文件 spring-mybatis-cms.xml中bean HikariDataSource的id
		 */
		public static final String CMS = "dataSource-cms";
	}
	
	/**
	 * 事务管理命名
	 */
	public static interface TransactionManagers {
		
		/**
		 * TransactionManager auth id
		 * 
		 * 同配置文件 spring-mybatis-auth.xml中bean DataSourceTransactionManager的id
		 */
		public static final String AUTH = "transactionManager-auth";
		
		/**
		 * TransactionManager cms id
		 * 
		 * 同配置文件 spring-mybatis-cms.xml中bean DataSourceTransactionManager的id
		 */
		public static final String CMS = "transactionManager-cms";
	}
	
}
