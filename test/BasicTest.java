import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

    @Test
    public void aVeryImportantThingToTest() {
        new Producto("Papas", 10.0).save();
        new Producto("Refresco", 8.0).save();
        new Producto("Chocolate", 12.0).save();
        new Producto("Limon", 1.0).save();
    }

}
