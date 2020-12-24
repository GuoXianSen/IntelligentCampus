package dao;


import entity.Goods;
import entity.HealthCode;

import java.util.List;

public interface IHealthCodeDao {
    /**
     * 删除健康码信息
     * @param userid
     * @return
     */
    int DeleteHealthCode(int userid);
    /**
     * 添加健康码信息
     * @param hc
     * @return
     */
    HealthCode AddHealthCode(HealthCode hc);

    List<HealthCode> getAllHealthCode();

}
