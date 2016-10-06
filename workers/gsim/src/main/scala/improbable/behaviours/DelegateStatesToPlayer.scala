package improbable.behaviours

import improbable.corelib.util.EntityOwnerUtils
import improbable.corelib.util.EntityOwnerDelegation._
import improbable.CheckIsLocalPlayer
import improbable.papi.entity.{Entity, EntityBehaviour}
import improbable.position.SpatialPosition
import improbable.unity.fabric.VisualEngineConstraint
import improbable.unity.papi.SpecificEngineConstraint

class DelegateStatesToPlayer(entity : Entity) extends EntityBehaviour {

  // Delegate state authority
  entity.delegateStateToOwner[CheckIsLocalPlayer]
  entity.delegateStateToOwner[SpatialPosition]

  // Add worker engine constraints
  entity.addEngineConstraint(SpecificEngineConstraint(EntityOwnerUtils.ownerIdOf(entity)))
  entity.addEngineConstraint(VisualEngineConstraint)
}
