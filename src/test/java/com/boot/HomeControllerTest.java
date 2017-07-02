package com.boot;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.boot.controller.HomeController;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipwrackRepository;

public class HomeControllerTest {

    @InjectMocks
    HomeController hc;

    @Mock
    ShipwrackRepository shipwrapcksRepoMock;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGet() {
        Shipwreck mocked = new Shipwreck();
        mocked.setId(1l);
        when(shipwrapcksRepoMock.findOne(1l)).thenReturn(mocked);

        Shipwreck returened = hc.get(1l);

        verify(shipwrapcksRepoMock).findOne(1l);
        assertEquals(returened, mocked);
        assertThat(returened.getId(), is(1l));
    }

}
