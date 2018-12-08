import org.junit.Test;

import static org.junit.Assert.*;


public class ATest {
    @Test
    public void instanceOne(){
        assertSame(A.met(1),"pierwszy" );
    }

    @Test
    public void instanceTwo(){
        assertSame(A.met(2),"drugi" );
    }

    @Test
    public void instanceThree(){
        assertSame(A.met(4),"inny" );
    }
}