package improbable.entities

import improbable.behaviours.DelegateStatesToBot
import improbable.math.{Coordinates, Vector3f}
import improbable.papi.entity.{EntityPrefab, EntityRecordTemplate}

object BotEntity {
  def apply(position: Coordinates): EntityRecordTemplate = new EntityDescriptor {
    val prefab = EntityPrefab("Bot")
    val states = Seq(

    )
    val behaviours = Seq(
      descriptorOf[DelegateStatesToBot]
    )
  }.record
}
