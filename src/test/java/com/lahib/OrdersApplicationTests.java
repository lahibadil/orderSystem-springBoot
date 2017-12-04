package com.lahib;

import com.lahib.db.controllers.SupplierController;
import com.lahib.db.entities.Supplier;
import com.lahib.db.services.SupplierService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrdersApplicationTests {

    @Mock
    SupplierService supplierServiceMock;

    @InjectMocks
    SupplierController supplierController;

    @Before
    public void before(){
         when(supplierServiceMock.save(new Supplier())).thenReturn(new Supplier());
    }
    @Test
    public void contextLoads() {
        Supplier supplier = supplierServiceMock.save(new Supplier());
        assert(true);
        assertNotNull(supplier);
    }
}
