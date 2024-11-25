package ulpgc.es;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TsvTitleDeserializer implements TitleDeserializer{
    public Title deserialize(String line){
        String[]columns=line.split("\t");
        return new Title(columns[0],typeOf(columns[1]),columns[2],columns[3], genre(columns[4]));
    }

    private Title.TitleType typeOf(String column) {
        return null;
    }

    private List<Title.Genre> genre(String column) {
        Set<String> validGenres = Arrays.stream(Title.Genre.values())
                .map(Enum::name)
                .collect(Collectors.toSet());
        return Arrays
                .stream(column.split(","))
                .map(String::trim)
                .filter(validGenres::contains)
                .map(Title.Genre::valueOf)
                .collect(Collectors.toList());
    }
}
