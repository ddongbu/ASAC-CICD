package TestController;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/api/GetMappingTest")
    public static String GetMappingTest() {
        return "GetMappingTest";
    }


}
