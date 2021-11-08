package com.example.myunittesting

class MainViewModel(private val cuboidModel: CuboidModel) {
    fun getVolume() = cuboidModel.getVolume()

    fun getSurfaceArea() = cuboidModel.getSurfaceArea()

    fun getCircumference() = cuboidModel.getCircumference()

    fun save(w: Double, l: Double, h: Double){
        cuboidModel.save(w, l, h)
    }
}