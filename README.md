# wwa-windows

A minimal template for building [Windows Store Apps](http://msdn.microsoft.com/library/windows/apps/dn726767.aspx) with ClojureScript.

## Usage

- Create a new project:
  ```
  lein new wwa-windows my-app
  ```

- Complie the ClojureScript:
  ```
  cd my-app\my-app
  lein cljsbuild auto
  ```

- Run the app:
  - Open the Visual Studio solution at `my-app\my-app.sln`
  - Hit F5 to run the app

## Requirements

- [Windows 8.1](http://windows.microsoft.com/en-us/windows-8/meet)
- [Visual Studio Express 2013 for Windows](http://www.visualstudio.com/en-us/downloads#d-express-windows-8)
- [Leiningen](http://leiningen.org/)

## Troubleshooting

If you receive an error that looks like this:

> The app couldn’t resolve ms-appx://d31bfc06-847b-413e-b5c5-b3d1f4025247/out/my_app/some_file.js because of this error: RESOURCE_NOT_FOUND.

Stop debugging (shift+F5) and click the "Refresh" button in the Solution Explorer:

![Solution Explorer refresh button](https://cloud.githubusercontent.com/assets/199935/3815704/d4640ca0-1cc7-11e4-99a9-4d95e586fd06.png)


This will force Visual Studio to recognize any new files that have been added to the output directory.

## License

Copyright (c) Microsoft Open Technologies, Inc. All rights reserved.
This program is made available under the terms of the Eclipse Public
License v1.0 which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html
