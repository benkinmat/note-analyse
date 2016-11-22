package web.dao;

public abstract class DaoFactory {
	
	public static final int MONGO_DATABASE = 1;
	public static final int MYSQL_DATABASE = 2;
	public static final int ORACLE_DATABASE = 3;

	public abstract UserDao getUserDao();
	
	public static DaoFactory getDaoFactory(int factoryId){
		
		switch (factoryId) {
		case MONGO_DATABASE:
			return new MongoDaoFactory();
		case MYSQL_DATABASE:
			return null;
		case ORACLE_DATABASE:
			return null;
		default:
			return null;
		}
		
	}
	
}
