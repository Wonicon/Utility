package chisel3 {

  import chisel3.internal._
  import chisel3.experimental.BaseModule

  object XSCompatibility {
    // Return the internal implicit BaseModule
    def currentModule: Option[BaseModule] = Builder.currentModule

    // Return the circuit owning the current module.  Keeping this accessor in
    // the chisel3 package preserves access to Chisel's package-scoped circuit
    // handle for utility code without exposing Builder internals elsewhere.
    def currentCircuit: Option[BaseModule] = Builder.currentModule.flatMap(_._circuit)

    // Return the internal implicit whenContext
    def currentWhen: Option[WhenContext] = Builder.whenStack.headOption
  }
}
