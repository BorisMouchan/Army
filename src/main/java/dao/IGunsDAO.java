package dao;

import com.solvd.laba.model.Guns;

import java.util.List;

public interface IGunsDAO extends IBaseDAO<Guns>{
    List<Guns> getGunsByCaliber (long caliber);
}
