import static org.Task_1.MoodAnalyser.analyseMood;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class MoodAnalyserTest {

    @Test
    public void goodMood(){
        assertThat(analyseMood("That is a great day")).isEqualTo("Good");
    }

    @Test
    public void badMood(){
        assertThat(analyseMood("It`s a bad day today")).isEqualTo("Terrible");
    }

    @Test
    public void normalMood(){
        assertThat(analyseMood("It`s a regular day today")).isEqualTo("Normal");
    }
}
