import * as React from 'react';
import { goToBluApp } from 'react-native-blu-module';

export default function App() {
  React.useEffect(() => {
    goToBluApp();
  }, []);

  return null;
}
