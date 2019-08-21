workflow "Build and Test " {
  resolves = ["vgaidarji/android-github-actions/emulator@v1.0.0"]
  on = "push"
}

action "vgaidarji/android-github-actions/build@v1.0.0" {
  uses = "vgaidarji/android-github-actions/build@v1.0.0"
}

action "vgaidarji/android-github-actions/emulator@v1.0.0" {
  uses = "vgaidarji/android-github-actions/emulator@v1.0.0"
  needs = ["vgaidarji/android-github-actions/build@v1.0.0"]
}
