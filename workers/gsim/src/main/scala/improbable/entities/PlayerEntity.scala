package improbable.entities

import improbable.CheckIsLocalPlayer
import improbable.behaviours.DelegateStatesToPlayer
import improbable.math.Coordinates
import improbable.papi.engine._
import improbable.papi.entity.{EntityPrefab, EntityRecordTemplate}

/**
  * Created by chong-u on 06/10/2016.
  */
object PlayerEntity  {
  def apply(position: Coordinates, owner: EngineId): EntityRecordTemplate = new EntityDescriptor {
    val prefab = EntityPrefab("Player")
    val states = Seq( CheckIsLocalPlayer() )
    val behaviours = Seq(descriptorOf[DelegateStatesToPlayer])
  }.record
}
