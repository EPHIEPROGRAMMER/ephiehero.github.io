import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

 public class HeroTest {

   @Test
   public void newHero_instantiatesCorrectly() {
     Hero testHero = new Hero("githeriman", 32, "githeri", "pizza");
     assertEquals(true, testHero instanceof Hero);
   }

   @Test
   public void getName_getsHeroName_String() {
     Hero testHero = new Hero("githeriman", 32, "githeri", "pizza");
     assertEquals("githeriman", testHero.getName());
   }

   @Test
   public void getAge_getsHeroAge_int() {
     Hero testHero = new Hero("githeriman", 32, "githeri", "pizza");
     assertEquals(32, testHero.getAge());
   }


   @Test
   public void getStrength_getsHeroStrength_String() {
     Hero testHero = new Hero("githeriman", 32, "githeri", "pizza");
     assertEquals("githeri", testHero.getStrength());
   }

   @Test
   public void getWeakness_getsHeroWeakness_String() {
     Hero testHero = new Hero("githeriman", 32, "githeri", "pizza");
     assertEquals("pizza", testHero.getWeakness());
   }

   @Test
   public void hasConcededDefeat_isFalseAfterInstantiation_false() {
     Hero testHero = new Hero("githeriman", 32, "githeri", "pizza");
     assertEquals(false, testHero.hasConcededDefeat());
   }

   @Test
   public void getCreatedAt_instantiatesWithCurrentTime_today() {
     Hero testHero = new Hero("githeriman", 32, "githeri", "pizza");
     assertEquals(LocalDateTime.now().getDayOfWeek(), testHero  .getCreatedAt().getDayOfWeek());
   }

   @Test
   public void all_returnsAllInstancesOfHero_true() {
    Hero firstHero = new Hero("githeriman", 32, "githeri", "pizza");
    Hero secondHero = new Hero("saltbae", 35, "salt", "sugar");
    assertEquals(true, Hero.all().contains(firstHero));
    assertEquals(true, Hero.all().contains(secondHero));
  }

  @Test
  public void clear_emptiesAllHeroesFromArrayList_0() {
    Hero testHero = new Hero("githeriman", 32, "githeri", "pizza");
    Hero.clear();
    assertEquals(Hero.all().size(), 0);
  }

  @Test
  public void getId_heroesInstantiateWithAnID_1() {
    Hero.clear();  // Remember, the test will fail without this line! We need to empty leftover Tasks from previous tests!
    Hero testHero = new Hero("githeriman", 32, "githeri", "pizza");
    assertEquals(1, testHero.getId());
  }

  @Test
  public void find_returnsHeroWithSameId_secondHero() {
    Hero firstHero = new Hero("githeriman", 32, "githeri", "pizza");
    Hero secondHero = new Hero("saltbae", 35, "salt", "sugar");
    assertEquals(Hero.find(secondHero.getId()), secondHero);
  }
 }
