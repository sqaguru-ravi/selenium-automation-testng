package framework;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method; // <-- Import added
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class JsonDataProvider {

    @DataProvider(name = "jsonDataProvider")
    public Object[][] getDataFromJson(Method method) throws IOException {
        // Get the file path from the annotation
        JsonFilePath annotation = method.getAnnotation(JsonFilePath.class);
        if (annotation == null) {
            throw new IllegalArgumentException("Missing @JsonFilePath annotation on method: " + method.getName());
        }
        String jsonFilePath = annotation.value();

        // Parse JSON into a nested map
        Type type = new TypeToken<List<Map<String, Object>>>() {}.getType();
        List<Map<String, Object>> testDataList = new Gson().fromJson(new FileReader(jsonFilePath), type);

        // Convert List to Object[][]
        Object[][] data = new Object[testDataList.size()][1];
        for (int i = 0; i < testDataList.size(); i++) {
            data[i][0] = testDataList.get(i);
        }

        return data;
    }
}