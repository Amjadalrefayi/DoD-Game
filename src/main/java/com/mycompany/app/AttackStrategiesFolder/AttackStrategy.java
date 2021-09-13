package com.mycompany.app.AttackStrategiesFolder;

import java.util.List;
import com.mycompany.app.Unit;

public interface AttackStrategy {

    public Unit PrioritizeUnitToAttack(List<Unit> unit);
    
}
