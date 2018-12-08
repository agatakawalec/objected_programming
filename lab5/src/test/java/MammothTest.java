import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MammothTest {
    @Rule public ExpectedException thrown = ExpectedException.none();

    @Test public void ordinaryTest() {
        //not throws anything - O.K.
    }
    @Test
    public void isException() throws InadequateFoodException{
        thrown.expect(InadequateFoodException.class);
        thrown.expectMessage("I don't like meat");
        Mammoth m= new Mammoth();
        m.eat(new Meat());
    }
}