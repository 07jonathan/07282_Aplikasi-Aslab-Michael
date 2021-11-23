package Entity;
import java.util.Date;
import java.util.List;

public abstract class EntityAbstract {
    protected int id;
    protected Date created_at, updated_at;
    
    public EntityAbstract(){}
    
    public EntityAbstract(int id, Date created_at, Date updated_at){
    this.id = id;
    this.created_at = created_at;
    this.updated_at = updated_at;
    }
    
    public int getId(){
    return id;
    }
    
    public Date getCreated_at(){
    return created_at;
    }
    
    public Date getUpdated_at(){
    return updated_at;
    }
}
