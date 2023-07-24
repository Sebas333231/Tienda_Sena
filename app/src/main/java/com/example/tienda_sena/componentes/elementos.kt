package com.example.tienda_sena.componentes

import com.example.tienda_sena.R

sealed class elementos(
    val imagen: Int,
    val nombre: String,
    val precio: String,
    val descripcion:  String,
    val primero: Double,
    val Segundo: Double
){
    object elemento1: elementos(nombre = "Cebolla", imagen = R.drawable.cebolla, precio = "2000", descripcion = "La cebolla es fuente de vitaminas y minerales, y es que gracias a " +
            " su composición es rica en azúcar natural, vitaminas A, B6, C y E, así como minerales como el sodio, " +
            "el potasio, el hierro, la fibra y el ácido fólico, entre otros.", primero = 4.694168, Segundo = -74.218453)

    /*object elemento2: elementos(nombre = "Manzana", imagen = R.drawable.manzanaroja, precio = "2000", descripcion = "La manzana está compuesta por 85% de agua, y la mayor parte de" +
            " sus azúcares deriva de la fructosa -aunque, en menor cantidad, tiene glucosa y sacarosa-." +
            " Además, aporta una escasa cantidad de vitamina C, también posee vitamina E -la cual es un" +
            " antioxidante-, y dentro de los minerales se destaca el potasio.")*/

    object elemento3: elementos(nombre = "Melon", imagen = R.drawable.melon, precio = "3000", descripcion = "El consumo de melón nos aporta agua, vitaminas A, B, C y E, " +
            " ácido fólico, fibra, además de minerales como calcio, hierro y potasio; " +
            " todos estos componentes favorecen a: Mantener hidratado nuestro el cuerpo en " +
            " días calurosos al mismo tiempo que consumimos una botana dulce baja en calorías.", primero = 4.694168, Segundo = -74.218453)

    object elemento4: elementos(nombre = "Leche", imagen = R.drawable.botella_leche, precio = "10000", descripcion = "La leche contribuye a consumir la cantidad necesaria de nutrientes" +
            " --como calcio, magnesio, selenio, riboflavina, vitamina B12 y ácido pantoténico--," +
            " que se requieren para una buena salud.", primero = 4.695038, Segundo = -74.215446)

    object elemento5: elementos(nombre = "Lechuga", imagen = R.drawable.lechuga, precio = "1500", descripcion = "La lechuga es un alimento ideal para cuidar la salud cardiovascular, y es que tiene" +
            " un alto contenido en magnesio y potasio. Estos dos minerales ayudan a nuestro cuerpo a mantener" +
            " en perfecto estado el ritmo cardíaco. Por esta razón, consumir a diario esta lechuga es algo tan" +
            " beneficioso.", primero = 4.694168, Segundo = -74.218453)

    object elemento6: elementos(nombre = "Queso", imagen = R.drawable.queso, precio = "5500", descripcion = "El queso es un alimento elaborado a partir de la leche cuajada de vaca, cabra, oveja" +
            " u otros mamíferos. Sus diferentes estilos y sabores son el resultado del uso de distintas" +
            " especies de bacterias y mohos, niveles de nata en la leche, curación, tratamientos" +
            " en su proceso, etc.", primero = 4.695038, Segundo = -74.215446)

    object elemento7: elementos(nombre = "Arequipe", imagen = R.drawable.tarro_de_arequipe, precio = "3500", descripcion = "El dulce de leche, también conocido como manjar,  " +
            "manjar de leche,  arequipe, o cajeta,  es un producto lácteo,  producido por la cocción de leche con azúcar y que" +
            " generalmente se utiliza como cobertura de postres o para untar o jaspear", primero = 4.695038, Segundo = -74.215446)

    object elemento8: elementos(nombre = "Uvas", imagen = R.drawable.uvas, precio = "2000", descripcion = "La uva es la común denominación que reciben los frutos formados en los racimos" +
            " de la vid. Es usada mundialmente para su fermentación, ya que ésta da lugar al vino. Sembradas en viñas," +
            " crecen agrupadas en las parras de las vides entre seis y trescientas uvas por racimo.", primero = 4.694168, Segundo = -74.218453)
}


sealed class todos(
    val imagen: Int,
    val nombre: String,
    val precio: String
){
    object todo1: elementos(nombre = "Melon", imagen = R.drawable.melon, precio = "3.000", descripcion = "El consumo de melón nos aporta agua, vitaminas A, B, C y E, " +
            " ácido fólico, fibra, además de minerales como calcio, hierro y potasio; " +
            " todos estos componentes favorecen a: Mantener hidratado nuestro el cuerpo en " +
            " días calurosos al mismo tiempo que consumimos una botana dulce baja en calorías.", primero = 4.694168, Segundo = -74.218453)

    object todo2: elementos(nombre = "Cebolla", imagen = R.drawable.cebolla, precio = "2.000", descripcion = "La cebolla es fuente de vitaminas y minerales, y es que gracias a " +
            " su composición es rica en azúcar natural, vitaminas A, B6, C y E, así como minerales como el sodio, " +
            "el potasio, el hierro, la fibra y el ácido fólico, entre otros.", primero = 4.694168, Segundo = -74.218453)

    /*object todo3: elementos(nombre = "Manzana", imagen = R.drawable.manzanaroja, precio = "2.000", descripcion = "La manzana está compuesta por 85% de agua, y la mayor parte de" +
            " sus azúcares deriva de la fructosa -aunque, en menor cantidad, tiene glucosa y sacarosa-." +
            " Además, aporta una escasa cantidad de vitamina C, también posee vitamina E -la cual es un" +
            " antioxidante-, y dentro de los minerales se destaca el potasio.")*/

    object todo4: elementos(nombre = "Leche", imagen = R.drawable.botella_leche, precio = "10.000", descripcion = "La leche contribuye a consumir la cantidad necesaria de nutrientes" +
            " --como calcio, magnesio, selenio, riboflavina, vitamina B12 y ácido pantoténico--," +
            " que se requieren para una buena salud.", primero = 4.695038, Segundo = -74.215446)

    object todo5: elementos(nombre = "lechuga", imagen = R.drawable.lechuga, precio = "1.500", descripcion = "La lechuga es un alimento ideal para cuidar la salud cardiovascular, y es que tiene" +
            " un alto contenido en magnesio y potasio. Estos dos minerales ayudan a nuestro cuerpo a mantener" +
            " en perfecto estado el ritmo cardíaco. Por esta razón, consumir a diario esta lechuga es algo tan" +
            " beneficioso.", primero = 4.694168, Segundo = -74.218453)

    object todo6: elementos(nombre = "Queso", imagen = R.drawable.queso, precio = "5.500",  descripcion = "El queso es un alimento elaborado a partir de la leche cuajada de vaca, cabra, oveja" +
            " u otros mamíferos. Sus diferentes estilos y sabores son el resultado del uso de distintas" +
            " especies de bacterias y mohos, niveles de nata en la leche, curación, tratamientos" +
            " en su proceso, etc.", primero = 4.695038, Segundo = -74.215446)

    object todo7: elementos(nombre = "Arequipe", imagen = R.drawable.tarro_de_arequipe, precio = "3.500", descripcion = "El dulce de leche, también conocido como manjar,  " +
            "manjar de leche,  arequipe, o cajeta,  es un producto lácteo,  producido por la cocción de leche con azúcar y que" +
            " generalmente se utiliza como cobertura de postres o para untar o jaspear", primero = 4.695038, Segundo = -74.215446)

    object todo8: elementos(nombre = "Uvas", imagen = R.drawable.uvas, precio = "2.000", descripcion = "La uva es la común denominación que reciben los frutos formados en los racimos" +
            " de la vid. Es usada mundialmente para su fermentación, ya que ésta da lugar al vino. Sembradas en viñas," +
            " crecen agrupadas en las parras de las vides entre seis y trescientas uvas por racimo.", primero = 4.694168, Segundo = -74.218453)

    object todo9: elementos(nombre = "Huevos", imagen = R.drawable.huevos, precio = "15.000", descripcion = "Consumir un huevo al día aporta proteínas de calidad para mantener nuestros" +
            " tejidos, nos ayudan a evitar el sobrepeso y también mejoran nuestra salud cardiovascular", primero = 4.696385, Segundo = -74.214835)

    object todo10: elementos(nombre = "Pollo", imagen = R.drawable.pollo, precio = "10.000", descripcion = "La carne de pollo es fuente importante de nutrientes como proteínas, lípidos, Vitamina" +
            " 3 y minerales como calcio, hierro, zinc, sodio, potasio y magnesio, entre otros. De fácil digestión. ", primero = 4.696385, Segundo = -74.214835)

    object todo11: elementos(nombre = "Carne", imagen = R.drawable.carne, precio = "12.000", descripcion = "Es una fuente de vitamina B12; esta vitamina nos ayuda a metabolizar proteínas, a formar glóbulos rojos y a darle mantenimiento al sistema nervioso central. Es rica en zinc," +
            " que ayuda a protegernos contra el daño oxidativo, a la cicatrización de la piel y para crear hemoglobina.", primero = 4.696385, Segundo = -74.214835)

    object todo12: elementos(nombre = "Peras", imagen = R.drawable.peras, precio = "3.200", descripcion = "La pera es una fruta que posee vitaminas A, B, C y K, minerales como cobre, hierro, potasio y magnesio, además de ácidos saludables, su cáscara contiene fitonutrientes y" +
            " vitaminas que protegen al cuerpo de los radicales libres dañinos", primero = 4.694168, Segundo = -74.218453)

    object todo13: elementos(nombre = "Remolacha", imagen = R.drawable.remolacha, precio = "1.000", descripcion = "La remolacha contiene una gran concentración de antioxidantes responsables por combatir la inflamación en el organismo. Por eso es un arma secreta para aliviar y prevenir la artritis. Este vegetal también" +
            " tiene un efecto alcalino en nuestro cuerpo y mejora la salud de nuestras articulaciones y tejidos.", primero = 4.694168, Segundo = -74.218453)

    object todo14: elementos(nombre = "Zanahoria", imagen = R.drawable.zanahoria, precio = "1.200", descripcion = "Es un vegetal diurético que evita la retención de líquidos." +
            " No puede faltar en verano, ya que facilita el bronceado de manera saludable y totalmente natural.", primero = 4.694168, Segundo = -74.218453)

}


sealed class flores(
    val imagen: Int,
    val texto: String,
    val precio: String,
    val descripcion: String,
    val primero: Double,
    val Segundo: Double
){
    object flor1: flores(
        imagen = R.drawable.tuli, texto = "Tulipanes", precio = "3.500", descripcion = "Es un símbolo del amante perfecto, la pasión y el romanticismo. El tulipán es un símbolo de amor sincero." +
                " Es una flor increíblemente romántica que al regalarla expresas enamoramiento, pasión," +
                " amor incondicional, amor puro, etc.", primero = 4.694168, Segundo = -74.218453)

    object flor2: flores(imagen = R.drawable.girasoloes, texto = "Girasoles", precio = "5.000", descripcion = "El girasol es el símbolo del Sol y simboliza el amor y la admiración." +
            " Pero también la felicidad, la vitalidad, el positivismo y la energía." +
            " En la cultura china simboliza una larga vida y buena suerte.", primero = 4.694168, Segundo = -74.218453)

    object flor3: flores(imagen = R.drawable.rosas, texto = "Rosas", precio = "2.500", descripcion = "las rosas rojas pueden simbolizar admiración, belleza y el cariño que siente una amistad por otra.", primero = 4.694168, Segundo = -74.218453)
}
sealed class frutas(
    val imagen: Int,
    val texto: String,
    val precio: String,
    val descripcion: String,
    val primero: Double,
    val Segundo: Double
){
    object fruta1: frutas(texto = "Zanahoria", imagen = R.drawable.zanahoria, precio = "1.200", descripcion = "Es un vegetal diurético que evita la retención de líquidos." +
            " No puede faltar en verano, ya que facilita el bronceado de manera saludable y totalmente natural.", primero = 4.694168, Segundo = -74.218453)

    /*object fruta2: frutas(texto = "Manzana", imagen = R.drawable.manzanaroja, precio = "2.000", descripcion = "La manzana está compuesta por 85% de agua, y la mayor parte de" +
            " sus azúcares deriva de la fructosa -aunque, en menor cantidad, tiene glucosa y sacarosa-." +
            " Además, aporta una escasa cantidad de vitamina C, también posee vitamina E -la cual es un" +
            " antioxidante-, y dentro de los minerales se destaca el potasio.")*/

    object fruta3: frutas(texto = "Melon", imagen = R.drawable.melon, precio = "3.000", descripcion = "El consumo de melón nos aporta agua, vitaminas A, B, C y E, " +
            " ácido fólico, fibra, además de minerales como calcio, hierro y potasio; " +
            " todos estos componentes favorecen a: Mantener hidratado nuestro el cuerpo en " +
            " días calurosos al mismo tiempo que consumimos una botana dulce baja en calorías.", primero = 4.694168, Segundo = -74.218453)

    object fruta4: frutas(texto = "Uvas", imagen = R.drawable.uvas, precio = "2.000", descripcion = "La uva es la común denominación que reciben los frutos formados en los racimos" +
            " de la vid. Es usada mundialmente para su fermentación, ya que ésta da lugar al vino. Sembradas en viñas," +
            " crecen agrupadas en las parras de las vides entre seis y trescientas uvas por racimo.", primero = 4.694168, Segundo = -74.218453)

    object fruta5: frutas(texto = "Peras", imagen = R.drawable.peras, precio = "3.200", descripcion = "La pera es una fruta que posee vitaminas A, B, C y K, minerales como cobre, hierro, potasio y magnesio, además de ácidos saludables," +
            " su cáscara contiene fitonutrientes y vitaminas que protegen al cuerpo de los radicales libres dañinos", primero = 4.694168, Segundo = -74.218453)

    object fruta6: frutas(texto = "Remolacha", imagen = R.drawable.remolacha, precio = "1.000", descripcion = "La remolacha contiene una gran concentración de antioxidantes responsables por combatir la inflamación en el organismo. Por eso es un arma secreta para aliviar" +
            " y prevenir la artritis. Este vegetal también tiene un efecto alcalino en nuestro cuerpo y mejora" +
            " la salud de nuestras articulaciones y tejidos.", primero = 4.694168, Segundo = -74.218453)

    object fruta7: frutas(texto = "lechuga", imagen = R.drawable.lechuga, precio = "1.500", descripcion = "La lechuga es un alimento ideal para cuidar la salud cardiovascular, y es que tiene" +
            " un alto contenido en magnesio y potasio. Estos dos minerales ayudan a nuestro cuerpo a mantener" +
            " en perfecto estado el ritmo cardíaco. Por esta razón, consumir a diario esta lechuga es algo tan" +
            " beneficioso.", primero = 4.694168, Segundo = -74.218453)

    object fruta8: frutas(texto = "Cebolla", imagen = R.drawable.cebolla, precio = "2.000", descripcion = "La cebolla es fuente de vitaminas y minerales, y es que gracias a " +
            " su composición es rica en azúcar natural, vitaminas A, B6, C y E, así como minerales como el sodio, " +
            "el potasio, el hierro, la fibra y el ácido fólico, entre otros.", primero = 4.694168, Segundo = -74.218453)
}


sealed class carnicos(
    val imagen: Int,
    val texto: String,
    val precio: String,
    val descripcion: String,
    val primero: Double,
    val Segundo: Double
){
    object carnicos1: carnicos(texto = "Huevos", imagen = R.drawable.huevos, precio = "15.000", descripcion = "Consumir un huevo al día aporta proteínas de calidad para mantener nuestros" +
            " tejidos, nos ayudan a evitar el sobrepeso y también mejoran nuestra salud cardiovascular", primero = 4.696385, Segundo = -74.214835)

    object carnicos2: carnicos(texto = "Pollo", imagen = R.drawable.pollo, precio = "10.000", descripcion = "La carne de pollo es fuente importante de nutrientes como proteínas, lípidos, Vitamina 3 y minerales como calcio," +
            " hierro, zinc, sodio, potasio y magnesio, entre otros. De fácil digestión. ", primero = 4.696385, Segundo = -74.214835)

    object carnicos3: carnicos(texto = "Carne", imagen = R.drawable.carne, precio = "12.000", descripcion = "Es una fuente de vitamina B12; esta vitamina nos ayuda a metabolizar proteínas, a formar glóbulos rojos y a darle mantenimiento al sistema nervioso central. Es rica en zinc," +
            " que ayuda a protegernos contra el daño oxidativo, a la cicatrización de la piel y para crear hemoglobina.", primero = 4.696385, Segundo = -74.214835)
}


sealed class lacteos(
    val imagen: Int,
    val texto: String,
    val precio: String,
    val descripcion: String,
    val primero: Double,
    val Segundo: Double
){
    object lacteos1: lacteos(texto = "Queso", imagen = R.drawable.queso, precio = "5.500",  descripcion = "El queso es un alimento elaborado a partir de la leche cuajada de vaca, cabra, oveja" +
            " u otros mamíferos. Sus diferentes estilos y sabores son el resultado del uso de distintas" +
            " especies de bacterias y mohos, niveles de nata en la leche, curación, tratamientos" +
            " en su proceso, etc.", primero = 4.695038, Segundo = -74.215446)

    object lacteos2: lacteos(texto = "Arequipe", imagen = R.drawable.tarro_de_arequipe, precio = "3.500", descripcion = "El dulce de leche, también conocido como manjar,  " +
            "manjar de leche,  arequipe, o cajeta,  es un producto lácteo,  producido por la cocción de leche con azúcar y que" +
            " generalmente se utiliza como cobertura de postres o para untar o jaspear", primero = 4.695038, Segundo = -74.215446)

    //buscar
    object lacteos3: lacteos(texto = "Uvas", imagen = R.drawable.uvas, precio = "2.000", descripcion = "", primero = 4.695038, Segundo = -74.215446)

    object lacteos4: lacteos(texto = "Leche", imagen = R.drawable.botella_leche, precio = "10.000", descripcion = "La leche contribuye a consumir la cantidad necesaria de nutrientes" +
            " --como calcio, magnesio, selenio, riboflavina, vitamina B12 y ácido pantoténico--," +
            " que se requieren para una buena salud.", primero = 4.695038, Segundo = -74.215446)
}

sealed class noticias(
    val imagen: Int,
    val texto: String,
    val precio: String,
    val descripcion: String,
    val primero: Double,
    val Segundo: Double
){
    object noticia1: noticias(texto = "Gran Feria", imagen = R.drawable.imagen1, precio = "", descripcion = "Si cuentas con un emprendimiento" +
            " que quieras dar a conocer, podras tener tu oportunidad en el marco de la celebracion del dia del Campesino", primero = 4.69606, Segundo = -74.21563)
    object noticia2: noticias(texto = "Vacantes", imagen = R.drawable.imagen2, precio = "", descripcion = "Trabaja en Estados Unidos 200 vacantes " +
            "para enfermeros", primero = 4.69606, Segundo = -74.21563)
    object noticia3: noticias(texto = "Por el Cambio", imagen = R.drawable.imagen3, precio = "", descripcion = "Trabajo por el campo Proyecto de reforma laboral", primero = 4.69606, Segundo = -74.21563)
}


sealed class ofertas_carnes(
    val imagen: Int,
    val texto: String,
    val precio: String,
    val precio_ahora: String,
    val descripcion: String,
    val primero: Double,
    val Segundo: Double
){
    object carnicos_oferta: ofertas_carnes(texto = "Huevos", imagen = R.drawable.huevos, precio = "15.000", precio_ahora = "10.500",descripcion = "Consumir un huevo al día aporta proteínas de calidad para mantener nuestros" +
            " tejidos, nos ayudan a evitar el sobrepeso y también mejoran nuestra salud cardiovascular", primero = 4.696385, Segundo = -74.214835)

    object carnicos_oferta2: ofertas_carnes(texto = "Pollo", imagen = R.drawable.pollo, precio = "10.000", precio_ahora = "7.000",descripcion = "La carne de pollo es fuente importante de nutrientes como proteínas, lípidos, Vitamina 3 y minerales como calcio," +
            " hierro, zinc, sodio, potasio y magnesio, entre otros. De fácil digestión. ", primero = 4.696385, Segundo = -74.214835)

    object carnicos_oferta3: ofertas_carnes(texto = "Carne", imagen = R.drawable.carne, precio = "12.000", precio_ahora = "8.400",descripcion = "Es una fuente de vitamina B12; esta vitamina nos ayuda a metabolizar proteínas, a formar glóbulos rojos y a darle mantenimiento al sistema nervioso central. Es rica en zinc," +
            " que ayuda a protegernos contra el daño oxidativo, a la cicatrización de la piel y para crear hemoglobina.", primero = 4.696385, Segundo = -74.214835)

}

sealed class ofertas_vegetales(
    val imagen: Int,
    val texto: String,
    val precio: String,
    val precio_ahora: String,
    val descripcion: String,
    val primero: Double,
    val Segundo: Double
){
    object frutas1: ofertas_vegetales(texto = "Zanahoria", imagen = R.drawable.zanahoria, precio = "1.200", precio_ahora = "960",descripcion = "Es un vegetal diurético que evita la retención de líquidos." +
            " No puede faltar en verano, ya que facilita el bronceado de manera saludable y totalmente natural.", primero = 4.694168, Segundo = -74.218453)

    /*object fruta2: ofertas_vegetales(texto = "Manzana", imagen = R.drawable.manzanaroja, precio = "2.000", descripcion = "La manzana está compuesta por 85% de agua, y la mayor parte de" +
            " sus azúcares deriva de la fructosa -aunque, en menor cantidad, tiene glucosa y sacarosa-." +
            " Además, aporta una escasa cantidad de vitamina C, también posee vitamina E -la cual es un" +
            " antioxidante-, y dentro de los minerales se destaca el potasio.")*/

    object frutas3: ofertas_vegetales(texto = "Melon", imagen = R.drawable.melon, precio = "3.000", precio_ahora = "2.400",descripcion = "El consumo de melón nos aporta agua, vitaminas A, B, C y E, " +
            " ácido fólico, fibra, además de minerales como calcio, hierro y potasio; " +
            " todos estos componentes favorecen a: Mantener hidratado nuestro el cuerpo en " +
            " días calurosos al mismo tiempo que consumimos una botana dulce baja en calorías.", primero = 4.694168, Segundo = -74.218453)

    object frutas4: ofertas_vegetales(texto = "Uvas", imagen = R.drawable.uvas, precio = "2.000", precio_ahora = "1.600",descripcion = "La uva es la común denominación que reciben los frutos formados en los racimos" +
            " de la vid. Es usada mundialmente para su fermentación, ya que ésta da lugar al vino. Sembradas en viñas," +
            " crecen agrupadas en las parras de las vides entre seis y trescientas uvas por racimo.", primero = 4.694168, Segundo = -74.218453)

    object frutas5: ofertas_vegetales(texto = "Peras", imagen = R.drawable.peras, precio = "3.200", precio_ahora = "2.560",descripcion = "La pera es una fruta que posee vitaminas A, B, C y K, minerales como cobre, hierro, potasio y magnesio, además de ácidos saludables," +
            " su cáscara contiene fitonutrientes y vitaminas que protegen al cuerpo de los radicales libres dañinos", primero = 4.694168, Segundo = -74.218453)

    object frutas6: ofertas_vegetales(texto = "Remolacha", imagen = R.drawable.remolacha, precio = "1.000", precio_ahora = "800",descripcion = "La remolacha contiene una gran concentración de antioxidantes responsables por combatir la inflamación en el organismo. Por eso es un arma secreta para aliviar" +
            " y prevenir la artritis. Este vegetal también tiene un efecto alcalino en nuestro cuerpo y mejora" +
            " la salud de nuestras articulaciones y tejidos.", primero = 4.694168, Segundo = -74.218453)

    object frutas7: ofertas_vegetales(texto = "lechuga", imagen = R.drawable.lechuga, precio = "1.500", precio_ahora = "1.200",descripcion = "La lechuga es un alimento ideal para cuidar la salud cardiovascular, y es que tiene" +
            " un alto contenido en magnesio y potasio. Estos dos minerales ayudan a nuestro cuerpo a mantener" +
            " en perfecto estado el ritmo cardíaco. Por esta razón, consumir a diario esta lechuga es algo tan" +
            " beneficioso.", primero = 4.694168, Segundo = -74.218453)

    object frutas8: ofertas_vegetales(texto = "Cebolla", imagen = R.drawable.cebolla, precio = "2.000", precio_ahora = "1.600",descripcion = "La cebolla es fuente de vitaminas y minerales, y es que gracias a " +
            " su composición es rica en azúcar natural, vitaminas A, B6, C y E, así como minerales como el sodio, " +
            "el potasio, el hierro, la fibra y el ácido fólico, entre otros.", primero = 4.694168, Segundo = -74.218453)
}

sealed class ofertas_lacteos(
    val imagen: Int,
    val texto: String,
    val precio: String,
    val precio_ahora: String,
    val descripcion: String,
    val primero: Double,
    val Segundo: Double
){
    object lacteos_oferta1: ofertas_lacteos(texto = "Queso", imagen = R.drawable.queso, precio = "5.500", precio_ahora = "3.850",descripcion = "El queso es un alimento elaborado a partir de la leche cuajada de vaca, cabra, oveja" +
            " u otros mamíferos. Sus diferentes estilos y sabores son el resultado del uso de distintas" +
            " especies de bacterias y mohos, niveles de nata en la leche, curación, tratamientos" +
            " en su proceso, etc.", primero = 4.695038, Segundo = -74.215446)

    object lacteos_oferta2: ofertas_lacteos(texto = "Arequipe", imagen = R.drawable.tarro_de_arequipe, precio = "3.500", precio_ahora = "2.450",descripcion = "El dulce de leche, también conocido como manjar,  " +
            "manjar de leche,  arequipe, o cajeta,  es un producto lácteo,  producido por la cocción de leche con azúcar y que" +
            " generalmente se utiliza como cobertura de postres o para untar o jaspear", primero = 4.695038, Segundo = -74.215446)

    object lacteos_ofertas4: ofertas_lacteos(texto = "Leche", imagen = R.drawable.botella_leche, precio = "10.000", precio_ahora = "7.000",descripcion = "La leche contribuye a consumir la cantidad necesaria de nutrientes" +
            " --como calcio, magnesio, selenio, riboflavina, vitamina B12 y ácido pantoténico--," +
            " que se requieren para una buena salud.", primero = 4.695038, Segundo = -74.215446)
}