package ca.ubc.ece.cpen221.worlds;

import ca.ubc.ece.cpen221.worlds.ai.FoxAI;
import ca.ubc.ece.cpen221.worlds.ai.RabbitAI;
import ca.ubc.ece.cpen221.worlds.ai.TruckAI;
import ca.ubc.ece.cpen221.worlds.core.WorldImpl;
import ca.ubc.ece.cpen221.worlds.core.WorldUI;
import ca.ubc.ece.cpen221.worlds.items.Gardener;
import ca.ubc.ece.cpen221.worlds.items.Grass;
import ca.ubc.ece.cpen221.worlds.items.Mountain;
import ca.ubc.ece.cpen221.worlds.items.animals.*;
import ca.ubc.ece.cpen221.worlds.items.vehicles.Truck;
import ca.ubc.ece.cpen221.worlds.items.animals.Tiger;
import ca.ubc.ece.cpen221.worlds.items.animals.Bird;
import ca.ubc.ece.cpen221.worlds.ai.*;

import javax.swing.*;

/**
 * The Main class initializes a world with some {@link Grass}, {@link Rabbit}s,
 * {@link Fox}es, {@link Gnat}s, {@link Gardener},  {@link Tiger}, {@link Bird}, etc.
 * <p>
 * You may modify or add Items/Actors to the World.
 */
public class Main {

    static final int X_DIM = 40;
    static final int Y_DIM = 40;
    static final int SPACES_PER_GRASS = 7;
    static final int INITIAL_GRASS = X_DIM * Y_DIM / SPACES_PER_GRASS;
    static final int INITIAL_GNATS = INITIAL_GRASS / 4;
    static final int INITIAL_RABBITS = INITIAL_GRASS / 4;
    static final int INITIAL_FOXES = INITIAL_GRASS / 32;
    static final int INITIAL_BIRDS = INITIAL_GRASS / 8;
    static final int INITIAL_TIGERS = INITIAL_GRASS / 32;
    static final int INITIAL_BEARS = INITIAL_GRASS / 40;
    static final int INITIAL_HYENAS = INITIAL_GRASS / 32;
    static final int INITIAL_CARS = INITIAL_GRASS / 100;
    static final int INITIAL_TRUCKS = INITIAL_GRASS / 150;
    static final int INITIAL_MOTORCYCLES = INITIAL_GRASS / 64;
    static final int INITIAL_MEN = INITIAL_GRASS / 150;
    static final int INITIAL_WOMEN = INITIAL_GRASS / 100;
    static final int INITIAL_HUNTERS = INITIAL_GRASS / 150;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().createAndShowWorld();
            }
        });
    }

    public void createAndShowWorld() {
        World world = new WorldImpl(X_DIM, Y_DIM);
        initialize(world);
        new WorldUI(world).show();
    }

    public void initialize(World world) {
        addGrass(world);
        world.addActor(new Gardener());

        addGnats(world);
        addRabbits(world);
        addFoxes(world);
        addTrucks(world);
        addMountains(world);
        addTigers(world);
        addBirds(world);
        // TODO: You may add your own creatures here!
    }

    private void addGrass(World world) {
        for (int i = 0; i < INITIAL_GRASS; i++) {
            Location loc = Util.getRandomEmptyLocation(world);
            world.addItem(new Grass(loc));
        }
    }

    private void addGnats(World world) {
        for (int i = 0; i < INITIAL_GNATS; i++) {
            Location loc = Util.getRandomEmptyLocation(world);
            Gnat gnat = new Gnat(loc);
            world.addItem(gnat);
            world.addActor(gnat);
        }
    }

    private void addFoxes(World world) {
        FoxAI foxAI = new FoxAI();
        for (int i = 0; i < INITIAL_FOXES; i++) {
            Location loc = Util.getRandomEmptyLocation(world);
            Fox fox = new Fox(foxAI, loc);
            world.addItem(fox);
            world.addActor(fox);
        }
    }

    private void addRabbits(World world) {
        RabbitAI rabbitAI = new RabbitAI();
        for (int i = 0; i < INITIAL_RABBITS; i++) {
            Location loc = Util.getRandomEmptyLocation(world);
            Rabbit rabbit = new Rabbit(rabbitAI, loc);
            world.addItem(rabbit);
            world.addActor(rabbit);
        }
    }

    private void addTrucks(World world) {
        TruckAI truckAI = new TruckAI();
        for (int i = 0; i < INITIAL_TRUCKS; i++) {
            Location loc = Util.getRandomEmptyLocation(world);
            Truck truck = new Truck(truckAI, loc);
            world.addItem(truck);
            world.addActor(truck);
        }
    }

    private void addMountains(World world) {
        for (int i = 0; i < 5; i++) {
            Location loc = Util.getRandomEmptyLocation(world);
            Mountain mountain = new Mountain(loc);
            world.addItem(mountain);
        }
    }
    private void addTigers(World world) {
        TigerAI TigerAI = new TigerAI();
        for (int i = 0; i < INITIAL_TIGERS; i++) {
            Location loc = Util.getRandomEmptyLocation(world);
            Tiger tiger = new Tiger(TigerAI, loc);
            world.addItem(tiger);
            world.addActor(tiger);
        }
    }
    private void addBirds(World world) {
        BirdAI BirdAI = new BirdAI();
        for (int i = 0; i < INITIAL_BIRDS; i++) {
            Location loc = Util.getRandomEmptyLocation(world);
            Bird bird = new Bird(BirdAI, loc);
            world.addItem(bird);
            world.addActor(bird);
        }
    }
}