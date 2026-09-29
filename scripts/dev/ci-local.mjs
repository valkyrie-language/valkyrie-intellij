import { spawnSync } from 'node:child_process';
import { existsSync } from 'node:fs';
import { dirname, resolve } from 'node:path';
import { fileURLToPath } from 'node:url';

const root = resolve(dirname(fileURLToPath(import.meta.url)), '..', '..');
const vomlRoot = resolve(root, '..', 'voml-intellij');
const gradle = process.platform === 'win32' ? 'gradlew.bat' : './gradlew';

function run(label, cwd, args) {
  console.log(`\n==> ${label}`);
  const result = spawnSync(gradle, args, {
    cwd,
    stdio: 'inherit',
    shell: process.platform === 'win32',
  });
  if (result.status !== 0) {
    process.exit(result.status ?? 1);
  }
}

if (!existsSync(resolve(root, 'settings.gradle.kts'))) {
  console.error(`Not a plugin monorepo: ${root}`);
  process.exit(1);
}

if (!existsSync(vomlRoot)) {
  console.error(`Missing sibling voml-intellij: ${vomlRoot}`);
  process.exit(1);
}

run('voml-intellij buildPlugin', vomlRoot, ['buildPlugin']);
run('valkyrie-intellij verify', root, ['ciVerify']);
