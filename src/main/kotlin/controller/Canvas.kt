package controller

import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.canvas.GraphicsContext
import javafx.scene.control.ColorPicker
import javafx.scene.control.Slider
import javafx.scene.input.MouseEvent
import javafx.scene.paint.Color
import java.net.URL
import java.util.*

class Canvas: Initializable {

    @FXML
    private lateinit var canvas: javafx.scene.canvas.Canvas

    private lateinit var g: GraphicsContext

    private var bfX : Double = 0.0
    private var bfY : Double = 0.0


    override fun initialize(location: URL?, resources: ResourceBundle?) {
        g = canvas.graphicsContext2D
        g.fill = Color.WHITE
        g.stroke = Color.BLACK
        g.fillRect(0.0, 0.0, 1280.0, 720.0)
    }

    fun start(mouseEvent: MouseEvent) {
        g.beginPath()
        bfX = mouseEvent.x
        bfY = mouseEvent.y
        g.moveTo(bfX,bfY)
    }

    fun end(mouseEvent: MouseEvent) {
        g.lineTo(mouseEvent.x,mouseEvent.y)
        bfX = mouseEvent.x
        bfY = mouseEvent.y
        g.closePath()
    }

    fun drag(mouseEvent: MouseEvent) {
        g.lineTo(mouseEvent.x,mouseEvent.y)
        bfX = mouseEvent.x
        bfY = mouseEvent.y
        g.moveTo(bfX,bfY)
        g.stroke()
    }

    fun changeColor(event: ActionEvent) {
        g.closePath()
        val colors = event.source
        if(colors is ColorPicker)
            g.stroke = colors.value
        g.beginPath()
    }

    fun sizeChange(mouseDragEvent: MouseEvent) {
        g.closePath()
        val selector = mouseDragEvent.source
        if(selector is Slider)
            g.lineWidth = selector.value
        g.beginPath()
    }

    fun reset(event: ActionEvent) {
        g.fillRect(0.0, 0.0, 1280.0, 720.0)
    }


}