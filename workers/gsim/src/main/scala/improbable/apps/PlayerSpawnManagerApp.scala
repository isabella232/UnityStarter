package improbable.apps


import improbable.entities.PlayerEntity
import improbable.flagz.{FlagContainer, FlagInfo, ScalaFlagz}
import improbable.logging.Logger
import improbable.math.Coordinates
import improbable.papi.world.AppWorld
import improbable.papi.world.messaging.{EngineConnected, EngineDisconnected}
import improbable.papi.worldapp.WorldApp
import improbable.unity.fabric.engine.EnginePlatform

class PlayerSpawnerApp(world: AppWorld, logger: Logger) extends WorldApp {

  logger.info("Starting Player app")

  world.messaging.subscribe {
    case engineConnectedMsg: EngineConnected =>
      if (engineConnectedMsg.enginePlatform == EnginePlatform.UNITY_CLIENT_ENGINE) {
        engineConnected(engineConnectedMsg)
      }

    case engineDisconnectedMsg: EngineDisconnected =>
      if (engineDisconnectedMsg.enginePlatform == EnginePlatform.UNITY_CLIENT_ENGINE) {
        engineDisconnected(engineDisconnectedMsg)
      }
  }

  def engineConnected(engineConnectedMsg: EngineConnected): Unit = {
    val entityId = world.entities.spawnEntity(
      PlayerEntity(
        Coordinates.zero,
        engineConnectedMsg.engineId))

    logger.info(s"Spawning player $entityId for ${engineConnectedMsg.engineId}")
  }

  def engineDisconnected(engineDisconnectedMsg: EngineDisconnected): Unit = {
    logger.info(s"Player disconnected: ${engineDisconnectedMsg.engineId}")
  }
}