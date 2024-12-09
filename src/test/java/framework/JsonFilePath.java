package framework;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME) // Ensure this is set to RUNTIME
public @interface JsonFilePath {
    String value();
}