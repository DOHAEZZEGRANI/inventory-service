package ma.xproce.inventoryservice.service;

import ma.xproce.inventoryservice.dao.entities.Creator;

import java.util.List;

public interface CreatorManager {
public Creator addCreator (Creator creator);
public Creator UpdateCreator (Creator creator);
public Boolean deleteCreator (Creator creator);
public Boolean deleteCreatorByid (Integer id);
public Creator getCreatorByid (Integer id);
public List<Creator> getAllCreators ();
}
