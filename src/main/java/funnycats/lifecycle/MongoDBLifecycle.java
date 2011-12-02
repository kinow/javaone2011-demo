package funnycats.lifecycle;

import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.DB;
import com.mongodb.Mongo;

public class MongoDBLifecycle {

	private static final Logger LOGGER = LoggerFactory.getLogger(MongoDBLifecycle.class);
	
	private final Mongo mongo;
	private final DB db;
	
	public MongoDBLifecycle(String host, Integer port, String database) 
	throws UnknownHostException {
		super();
		
		mongo = new Mongo(host, port);
		db = mongo.getDB(database);
	}
	
	public Mongo getMongo() {
		return this.mongo;
	}
	
	public DB getDatabase() {
		return this.db;
	}
	
	public void close() {
		LOGGER.info("Shutting down MongoDB");
		if ( this.mongo != null ) {
			this.mongo.close();
		}
	}
	
}
