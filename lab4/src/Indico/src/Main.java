import io.indico.Indico;
import io.indico.api.results.IndicoResult;
import io.indico.api.utils.IndicoException;

import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] arg) {
        Indico indico = null;
        try {
            indico = new Indico("71961c96960a7a8b236781dbe6e6d872");
        } catch (IndicoException e) {
            e.printStackTrace();
        }
        IndicoResult single = null;
        try {
            single = indico.imageRecognition.predict(
                    "foto/bocian.jpg"
            );
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IndicoException e) {
            e.printStackTrace();
        }
        Map<String, Double> result = null;
        try {
            result = single.getImageRecognition();
        } catch (IndicoException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }
}
