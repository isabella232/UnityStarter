package improbable.behaviours

import improbable.papi.entity.{Entity, EntityBehaviour}
import improbable.position.SpatialPosition
import improbable.unity.fabric.{PhysicsEngineConstraint, VisualEngineConstraint}

class DelegateStatesToBot(entity : Entity) extends EntityBehaviour {

  // Delegate state authority
  entity.delegateState[SpatialPosition](PhysicsEngineConstraint)

  // Add worker engine constraints
  entity.addEngineConstraint(PhysicsEngineConstraint)
  entity.addEngineConstraint(VisualEngineConstraint)
}
