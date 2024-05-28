package pr.grifyl;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection = "letters")
public class Letter {
    @BsonId
    public ObjectId id;
    public String type;
    public String status;
    public String destination;
}
