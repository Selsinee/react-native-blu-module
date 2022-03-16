import { NativeModules, Platform } from 'react-native';

const LINKING_ERROR =
  `The package 'react-native-blu-module' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo managed workflow\n';

const BluModule = NativeModules.BluModule
  ? NativeModules.BluModule
  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );

export function goToBluApp() {
  BluModule.goToBluApp();
}
