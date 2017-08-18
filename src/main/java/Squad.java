import java.util.List;
import java.util.ArrayList;
import java.util.*;

public class Squad {
  private String mName;
  // private ArrayList<Hero>mGroup = new ArrayList<Hero>();
  private final int MAX_SIZE = 5;
  private static List<Squad> instances = new ArrayList<Squad>();
  private int mId;
  private List<Hero> mHeroes;

  public Squad(String name) {
    mName = name;
    instances.add(this);
    mId = instances.size();
    mHeroes = new ArrayList<Hero>();
  }

  public String getSquadName() {
    return mName;
  }

  // public ArrayList<Hero> getGroup() {
  //   return mGroup;
  // }

  // public void addHero(Hero hero) {
  //   mGroup.add(hero);
  // }

  // public String heroName(int heroId) {
  //   String name = mGroup.get(heroId).getName();
  //   return name;
  // }

  public static List<Squad> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public int getId() {
    return mId;
  }

  // public static Squad find(int id) {
  //   return instances.get(id - 1);
  // }

  public List<Hero> getHeroes() {
    return mHeroes;
  }

  public void addHero(Hero hero) {
    mHeroes.add(hero);
  }

  public static Squad find(int id) {
  try {
    return instances.get(id - 1);
  } catch (IndexOutOfBoundsException exception) {
    return null;
  }
}
}
