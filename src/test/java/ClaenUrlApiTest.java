import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ClaenUrlApiTest {

    @Test
    //Мне не удалось получить 200 ответ даже в постмане. Как-будто Апи не работает.
    // поэтому сложно было расписать более подробный ассерт.
    // Данный тест кейс проверяет отправку длинного URL (основной позитивный сценарий)
    public void testShortUrlPositive() {
        Response response = CleanUrlApiStep.getCleanUrl("https://software-testing.ru/lms/login/index.php");

        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(response.jsonPath().getString("result_url")).isNotEmpty();
    }

    @Test
    //В данном тест кейсе проверяется отправка пустого url
    // Должен прийти ответ с кодом 400
    // и телом "error": "API Error: URL is empty" - закомментил ассерт, не удалось реализовать
    public void testShortUrlNegative() {
        Response response = CleanUrlApiStep.getCleanUrl("");

        assertThat(response.statusCode()).isEqualTo(400);
        //assertThat(response.getBody()).isEqualTo("error: API Error: URL is empty");
    }
}

