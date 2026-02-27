package Q3;

// A simple stub agent that makes random legal choices
import java.util.*;

public class RandomAgent implements CatanAgent {

    private int playerId;
    private Random random = new Random();

    @Override
    public void init(int playerId) {
        this.playerId = playerId;
    }

    @Override
    public Move chooseInitialSettlement(GameState state) {
        // picks first legal move
        return state.getLegalMoves(playerId).get(0); 
    }

    @Override
    public Move chooseInitialRoad(GameState state) {
        return state.getLegalMoves(playerId).get(0);
    }

    @Override
    public Move chooseMove(GameState state) {
        List<Move> legalMoves = state.getLegalMoves(playerId);
        return legalMoves.get(random.nextInt(legalMoves.size()));
    }

    @Override
    public Map<ResourceType, Integer> chooseDiscard(GameState state, int discardCount) {
        // model stub behaviour by discarding nothing 
        return new HashMap<>(); 
    }

    @Override
    public ResourceType chooseResource(GameState state) {
        return ResourceType.values()[random.nextInt(ResourceType.values().length)];
    }

    @Override
    public int chooseRobberTarget(GameState state, List possibleTargets) {
        return (int) possibleTargets.get(0);
    }

    @Override
    public DevelopmentCard chooseDevelopmentCard(GameState state) {
        return DevelopmentCard.values()[0];
    }
}