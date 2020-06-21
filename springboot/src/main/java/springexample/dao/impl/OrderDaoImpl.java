package springexample.dao.impl;

import org.springframework.stereotype.Repository;
import springexample.dao.OrderDao;

/**
 * @Author zhaoxg
 * @Date 2020/6/21 13:07
 */
@Repository

public class OrderDaoImpl implements OrderDao {

    @Override
    public boolean createOrder() {
        System.out.println("start insert order");
        return false;
    }
}
