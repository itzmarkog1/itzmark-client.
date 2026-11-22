# Build itzMark Client with GitHub Actions

1. Create a GitHub repository (for example `itzmark-client`).
2. Upload the contents of this project folder to the repository root. Make sure the `.github/workflows/build.yml` file is included. In GitHub's upload interface, enable viewing hidden files if needed.
3. Open the repository's **Actions** tab.
4. Select **Build itzMark Client** and click **Run workflow**, or push a commit to start a build automatically.
5. Wait for the workflow to finish. A green check means the build succeeded.
6. Open the completed workflow run, scroll to **Artifacts**, and download `itzmark-client-fabric-1.21.11`.
7. Extract the artifact ZIP. The mod JAR will be inside. Use the normal mod JAR, not a `-sources.jar` file if one is present.

If the workflow fails, open the failed run and share the first red error section so the build can be fixed.

The JAR is not guaranteed until GitHub Actions completes successfully. This workflow builds the supplied source; it does not add gameplay modules that are not implemented in the source.
