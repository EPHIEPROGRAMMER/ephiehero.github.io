import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

 public class HeroTest {

   @Test
   public void newHero_instantiatesCorrectly() {
     Hero testHero = new Hero("Scorpion", 42, "Hellfire", "Subzero");
     assertEquals(true, testHero instanceof Hero);
   }

   @Test
   public void getName_getsHeroName_String() {
     Hero testHero = new Hero("Scorpion", 42, "Hellfire", "Subzero");
     assertEquals("Scorpion", testHero.getName());
   }

   @Test
   public void getAge_getsHeroAge_int() {
     Hero testHero = new Hero("Scorpion", 42, "Hellfire", "Subzero");
     assertEquals(42, testHero.getAge());
   }


   @Test
   public void getStrength_getsHeroStrength_String() {
     Hero testHero = new Hero("Scorpion", 42, "Hellfire", "Subzero");
     assertEquals("Hellfire", testHero.getStrength());
   }

   @Test
   public void getWeakness_getsHeroWeakness_String() {
     Hero testHero = new Hero("Scorpion", 42, "Hellfire", "Subzero");
     assertEquals("Subzero", testHero.getWeakness());
   }

   @Test
   public void hasConcededDefeat_isFalseAfterInstantiation_false() {
     Hero testHero = new Hero("Scorpion", 42, "Hellfire", "Subzero");
     assertEquals(false, testHero.hasConcededDefeat());
   }

   @Test
   public void getCreatedAt_instantiatesWithCurrentTime_today() {
     Hero testHero = new Hero("Scorpion", 42, "Hellfire", "Subzero");
     assertEquals(LocalDateTime.now().getDayOfWeek(), testHero  .getCreatedAt().getDayOfWeek());
   }

   @Test
   public void all_returnsAllInstancesOfHero_true() {
    Hero firstHero = new Hero("Scorpion", 42, "Hellfire", "Subzero");
    Hero secondHero = new Hero("Raiden", 1000, "Lightning", "Shinnok");
    assertEquals(true, Hero.all().contains(firstHero));
    assertEquals(true, Hero.all().contains(secondHero));
  }

  @Test
  public void clear_emptiesAllHeroesFromArrayList_0() {
    Hero testHero = new Hero("Scorpion", 42, "Hellfire", "Subzero");
    Hero.clear();
    assertEquals(Hero.all().size(), 0);
  }

  @Test
  public void getId_heroesInstantiateWithAnID_1() {
    Hero.clear();  // Remember, the test will fail without this line! We need to empty leftover Tasks from previous tests!
    Hero testHero = new Hero("Scorpion", 42, "Hellfire", "Subzero");
    assertEquals(1, testHero.getId());
  }

  @Test
  public void find_returnsHeroWithSameId_secondHero() {
    Hero firstHero = new Hero("Scorpion", 42, "Hellfire", "Subzero");
    Hero secondHero = new Hero("Raiden", 1000, "Lightning", "Shinnok");
    assertEquals(Hero.find(secondHero.getId()), secondHero);
  }
 }
