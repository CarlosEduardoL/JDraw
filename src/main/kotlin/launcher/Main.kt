package launcher

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage

class Main : Application() {
    fun play(arguments: Array<String>){
        Application.launch(*arguments)
    }

    override fun start(primaryStage: Stage?) {
        val root = FXMLLoader.load<Parent>(javaClass.getResource("/canvas.fxml"))
        val scene = Scene(root,1280.0, 720.0)
        primaryStage!!.scene = scene
        primaryStage.show()
    }

}

fun main(args: Array<String>){
    Main().play(args)
}