# Scala Generics Type Mismatch
This example demonstrates a common type mismatch error that can occur when using generics in Scala. The `+` operator is overloaded for different types, and this can cause unexpected behavior when the generic type `T` is not properly constrained.

The bug is in the `myMethod` function of `MyClass`. When `T` is an `Int`, the `+` operator performs addition. But when `T` is a `String`, it performs string concatenation.  The compiler doesn't detect this ambiguity, resulting in a runtime error when using strings.

The solution demonstrates how to constrain the generic type `T` to only types that support the `+` operator using a type class or implicit evidence parameter to handle the different types safely.