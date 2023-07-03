Local $hWnd = WinWaitActive("[CLASS:#32770]", "", 10)
Sleep(2000)
FileChangeDir(@WorkingDir & "\downloads")
$bad_path = @WorkingDir
$good_path = StringReplace($bad_path, ";", ":")
ControlSend($hWnd, "", "[CLASS:Edit; INSTANCE:1]", $good_path & "\avatar.png")
ControlClick($hWnd, "", "[CLASS:Button; INSTANCE:1]")
WinWaitClose($hWnd)