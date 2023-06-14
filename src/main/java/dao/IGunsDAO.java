package dao;

import com.solvd.laba.model.Gun;

import java.util.List;

public interface IGunsDAO extends IBaseDAO<Gun>{
    List<Gun> getGunsByCaliber (long caliber);
}
