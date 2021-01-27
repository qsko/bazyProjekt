package DAO;

import java.util.List;

public interface interfaceDAO {
	public void addObject(Object o);
	public void updateObject(Object o);
	public void removeObject(int id);
	public Object getObjectById(int id);
	public List<?> getObjectList();
}
