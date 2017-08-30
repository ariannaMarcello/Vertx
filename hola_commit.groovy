def eb = vertx.eventBus()

eb.consumer("com.syc.ws.angel", {message -> 
  println("Buzón Angel: ${message.body()}")

})

eb.consumer("com.syc.ws.ari", { message ->
  println ("Buzón Ari ${message.body()}")
  eb.send("com.syc.ws.angel", "Me acaba de mandar un mensaje Fer")
  message.reply("Bien, y tu ?")

})

eb.consumer("com.syc.pm.fer", { message ->
  println("Buzón Fer: ${message.body()}")
  eb.send("com.syc.ws.ari", "Hola como estas ??", {reply ->
    println( "Respuesta Ari: ${reply.result().body()}" )  

  })

})

eb.consumer("com.mk.bos.juan", { message ->

})

eb.consumer("com.edenred.pm.karina", { message ->

})

eb.send ("com.syc.pm.fer", "Inicia Conversación")